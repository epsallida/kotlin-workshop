package _0LazyProperty

// Add a custom getter to make the 'lazy' val really lazy.
// It should be initialized by the invocation of 'initializer()'
// at the moment of the first access.
// You can add as many additional properties as you need.
// Do not use delegated properties!

class LazyProperty(val initializer: () -> Int) {
    private var property: Int? = null

    val lazy2: Int get() {
        if (this.property == null) {
            this.property = initializer()
        }
        return this.property!!
    }

    val lazy: Int by lazy { initializer() }

    val lazyStr: String by lazy { "" }
}