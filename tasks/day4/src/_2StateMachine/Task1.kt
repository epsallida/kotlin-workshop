package _2StateMachine.task1

import _2StateMachine.*

fun setUpStateMachine(): StateMachine {
    val doorClosed = Event(DOOR_CLOSED)
    val drawerOpened = Event(DRAWER_OPENED)
    val lightOn = Event(LIGHT_ON)
    val doorOpened = Event(DOOR_OPENED)
    val panelClosed = Event(PANEL_CLOSED)

    val unlockPanel = Command(UNLOCK_PANEL)
    val lockPanel = Command(LOCK_PANEL)
    val lockDoor = Command(LOCK_DOOR)
    val unlockDoor = Command(UNLOCK_DOOR)

    val idle = State(IDLE)
    val active = State(ACTIVE)
    val waitingForLight = State(WAITING_FOR_LIGHT)
    val waitingForDrawer = State(WAITING_FOR_DRAWER)
    val unlockedPanel = State(UNLOCKED_PANEL)

    val machine = StateMachine(idle)

    // Support the following way to configure state machine.
    // Use (and implement) the interface StateBuilder defined below.

    idle.configure {
        commands(unlockDoor, lockPanel)
        transition(doorClosed, active)
    }
    active.configure {
        transition(drawerOpened, waitingForLight)
        transition(lightOn, waitingForDrawer)
    }
    waitingForLight.configure {
        transition(lightOn, unlockedPanel)
    }
    waitingForDrawer.configure {
//      transition(drawerOpened, unlockedPanel)
        drawerOpened .. unlockedPanel
    }
    unlockedPanel.configure {
        commands(unlockPanel, lockDoor)
        //transition(panelClosed, idle)
        // Bonus. Make the following way a legal way to define a transition.
        panelClosed..idle
    }

    machine.addResetEvent(doorOpened)
    return machine
}

interface StateBuilder {

    fun commands(vararg commands: Command)

    fun transition(event: Event, state: State)

    operator fun Event.rangeTo(state : State)

}

fun State.configure(config: StateBuilder.() -> Unit) : Unit {

    config(object: StateBuilder {
        override fun commands(vararg commands: Command) {
            for (c in commands) {
                addCommand(c)
            }
        }
        override fun transition(event: Event, state: State) {
            addTransition(event, state)
        }
        override fun Event.rangeTo(state: State) {
            addTransition(this, state)
        }
    })
}

