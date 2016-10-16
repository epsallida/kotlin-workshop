package _2StateMachine

class TestSample : AbstractTestStateMachine() {
    override fun setUpStateMachine() =
            _2StateMachine.sample.setUpStateMachine()
}

class TestTask1 : AbstractTestStateMachine() {
    override fun setUpStateMachine() =
            _2StateMachine.task1.setUpStateMachine()
}

class TestTask2 : AbstractTestStateMachine() {
    override fun setUpStateMachine() =
            _2StateMachine.task2.setUpStateMachine()
}

class TestTask3: AbstractTestStateMachine() {
    override fun setUpStateMachine() =
            _2StateMachine.task3.setUpStateMachine()
}