package _2StateMachine.task2

import _2StateMachine.*

// Support the following way to configure state machine.
// First way: Store the lamda's (Kotlin way)

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
    val lMap = mutableMapOf<State, StateBuilder.() -> Unit>()
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
        lMap.put(newState, config)
    }

    fun resetEvents(event: String) {
        resetMap.put(event, eventsMap[event]!!)
    }

    inner class StateBuilder(val state: State) {

        fun transition(event: String, target: String) {
            state.addTransition(eventsMap[event]!!, statesMap[target]!!)
        }

        fun commands(vararg commands: String) {
            commands.forEach {
                state.addCommand(commandsMap[it]!!)
            }
        }

    }
    fun buildStateMachine(): StateMachine {
        val stateMachine = StateMachine(statesMap[start]!!)

        for ((state, config) in lMap) {
            config(StateBuilder(state))
        }
        resetMap.forEach { stateMachine.addResetEvent(it.value) }

        return stateMachine
    }
}

fun stateMachine(start: String, config: StateMachineBuilder.() -> Unit): StateMachine {

    val stateMachineBuilder = StateMachineBuilder(start)
    stateMachineBuilder.config()
    return stateMachineBuilder.buildStateMachine()
}
