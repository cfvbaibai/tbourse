val cl = Action<Task> { println("I'm ${this.project.name}") }

allprojects {
    tasks.register("hello") { doLast(cl) }

    group = "cfvbaibai.tbourse"
}