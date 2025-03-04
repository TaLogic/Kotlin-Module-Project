class NotesMenu(private val nameOfArchive: String) {

    val menu = mutableListOf<MenuItem>()

    private fun viewNote(note: Note) {
        println("\nЗаметка \"${note.name}\":")
        println(note.content)
        println()
        UserInterface.printMenu(menu)
    }

    private fun createNote() {
        println("\nВведите название заметки:")
        val name = UserInterface.enterText()
        println("Введите содержание заметки:")
        val content = UserInterface.enterText()
        val note = Note(name, content)
        Archives.archives[nameOfArchive]?.add(note)
        println("Заметка \"$name\" создана\n")
        // println(Archives.archives)
        menu.add(menu.size - 1, MenuItem(name, action = {
            viewNote(note)
        }))
        UserInterface.printMenu(menu)
        // UserInterface.selectMenu(menu)
    }


    init {
        menu.add(MenuItem("Создать заметку", action = {
            createNote()
        }))
        Archives.archives[nameOfArchive]?.forEach {
                note -> menu.add(MenuItem(note.name, action = {
            viewNote(note)
        }))
        }

        menu.add(MenuItem("Назад", action = {
            println()
            UserInterface.printMenu(Archives.menu)
            UserInterface.selectMenu(Archives.menu)
        }))
    }
}