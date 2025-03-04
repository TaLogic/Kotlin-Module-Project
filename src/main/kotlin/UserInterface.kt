import java.util.Scanner

class UserInterface {
    companion object {
        private val scanner = Scanner(System.`in`)
        fun printMenu(menu: MutableList<MenuItem>) {
            menu.forEachIndexed { index, element -> println("$index. ${element.name}") }
        }

        fun selectMenu(menu: MutableList<MenuItem>) {
            while (true) {
                val selectedMenu = scanner.nextLine().trim()
                val selectedMenuNumber = selectedMenu.toIntOrNull()
                if (selectedMenuNumber != null) {
                    if ((selectedMenuNumber >= menu.size) or (selectedMenuNumber < 0)) {
                        println("\nЭлемента под номером $selectedMenuNumber нет. Введите существующий номер:")
                        printMenu(menu)
                    } else {
                        menu[selectedMenuNumber].action()
                    }
                } else {
                    println("\nЭто не число. Введите, пожалуйста, число, которое соотвествует одному из пунктов меню:")
                    printMenu(menu)
                }
            }
        }

        fun enterText(): String {
            var text: String
            while (true) {
                text = scanner.nextLine()
                if (text.trim().isNotEmpty()) {
                    return text.trim()
                }
                println("Поле не может быть пустым. Попробуйте еще:")
            }
        }
    }
}