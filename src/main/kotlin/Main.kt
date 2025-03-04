fun main(args: Array<String>) {
    println("\nДобро пожаловать в приложение \"Заметки\"")
    println("Введите число, которое отвечает за необходимый вам пункт меню")
    println("\nСписок архивов:")
    val archives = Archives()
    UserInterface.printMenu(Archives.menu)
    UserInterface.selectMenu(Archives.menu)
}
