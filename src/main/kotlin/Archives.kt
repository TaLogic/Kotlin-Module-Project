import kotlin.system.exitProcess

class Archives {
    companion object{
        val menu = mutableListOf<MenuItem>()
        val archives = mutableMapOf<String, MutableList<Note>>()
    }

    private fun createArchive(){
        println("\nВведите название архива:")
        val name = UserInterface.enterText()
        archives.put(name, mutableListOf())
        println("Архив \"$name\" создан\n")
        menu.add(menu.size - 1, MenuItem("Архив \"$name\"", action = {
            println("Открыт архив \"$name\"\n")
            val notes = NotesMenu(name)
            UserInterface.printMenu(notes.menu)
            UserInterface.selectMenu(notes.menu)
        }))
        // println(archives)
        UserInterface.printMenu(menu)
    }

    init {
        if (menu.isEmpty()) {
            menu.add(MenuItem("Создать архив") {
                createArchive()
            })
            menu.add(MenuItem("Выход", action = {
                exitProcess(0)
            }))
        }

    }
}