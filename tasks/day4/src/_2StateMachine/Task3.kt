package _2StateMachine.task3

import _2StateMachine.*

// Support the following way to configure state machine.
// Second way: Store all the Strings

fun setUpStateMachine(): StateMachine = stateMachine(start = IDLE) {

    event(DOOR_CLOSED)
    event(DRAWER_OPENED)
    event(LIGHT_ON)
    event(DOOR_OPENED)
    event(PANEL_CLOSED)

    command(UNLOCK_PANEL)
    command(LOCK_PANEL)
    command(LOCK_DOOR)
    command(UNLOCK_DOOR)

    state(IDLE) {
        transition(event = DOOR_CLOSED, target = ACTIVE)
        commands(UNLOCK_DOOR, LOCK_PANEL)
    }
    state(ACTIVE) {
        transition(DRAWER_OPENED, WAITING_FOR_LIGHT)
        transition(LIGHT_ON, WAITING_FOR_DRAWER)
    }
    state(WAITING_FOR_LIGHT) {
        transition(LIGHT_ON, UNLOCKED_PANEL)
    }
    state(WAITING_FOR_DRAWER) {
        transition(DRAWER_OPENED, UNLOCKED_PANEL)
    }
    state(UNLOCKED_PANEL) {
        commands(UNLOCK_PANEL, LOCK_DOOR)
        transition(PANEL_CLOSED, IDLE)
    }

    resetEvents(DOOR_OPENED)
}

class StateMachineBuilder(val start: String) {

    val eventsMap = mutableMapOf<String, Event>()
    val commandsMap = mutableMapOf<String, Command>()
    val transMap = mutableMapOf<String, Pair<String, String>>()
    val comsMap = mutableMapOf<String, List<String>>()
    val statesMap = mutableMapOf<String, State>()
    val resetMap = mutableMapOf<String, Event>()

    fun event(event: String) {
        eventsMap.put(event, Event(event))
    }
    fun command(com: String) {
        commandsMap.put(com, Command(com))
    }
    fun state(state: String, config: StateBuilder.() -> Unit) {
        val newState = State(state)
        statesMap.put(state, newState)
        config(StateBuilder(state))
    }
    fun resetEvents(event: String) {
        resetMap.put(event, eventsMap[event]!!)
    }

    inner class StateBuilder(val code: String) {

        fun transition(event: String, target: String) {
            transMap.put(code, Pair(event, target))
        }
        fun commands(vararg commands: String) {
            comsMap.put(code, commands.toList())
        }
    }

    fun buildStateMachine(): StateMachine {
        val stateMachine = StateMachine(statesMap[start]!!)

        comsMap.forEach({
            val state = statesMap.get(it.key)
            for (c in it.value) {
                state?.addCommand(commandsMap[c]!!)
            }
        })

        for (t in transMap) {
            val event = eventsMap[t.value.first]
            val target = statesMap.get(t.value.second)
            val st = statesMap.get(t.key)
            st?.addTransition(event!!, target!!)
        }
        resetMap.forEach { stateMachine.addResetEvent(it.value) }

        return stateMachine
    }
}

fun stateMachine(start: String, config: StateMachineBuilder.() -> Unit) : StateMachine {

    val stateMachineBuilder = StateMachineBuilder(start)
    stateMachineBuilder.config()
    return stateMachineBuilder.buildStateMachine()
}
