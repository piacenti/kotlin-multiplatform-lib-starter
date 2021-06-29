package test

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExampleTest: StringSpec() {
    init {
        "this is a test"{
            true shouldBe true
        }
    }
}