package webComponent

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

fun main(args: Array<String>) {
    if(args.size != 1)
        return

    val homefolder = createComponentFolder(args[0])
    createJsFile(homefolder, args[0])
    createHtmlFile(homefolder, args[0], isElectronApp())
    createCssFile(homefolder, args[0])
    importComponent(args[0])
}

fun isElectronApp() : Boolean {
    val packagejson = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/package.json"))

    for(s in packagejson) {
        if("\"electron\":" in s)
            return true;
    }

    return false;
}

fun createComponentFolder(name: String) = Files.createDirectory(Paths.get(System.getProperty("user.dir") + "/src/components/" + name))

fun createJsFile(path: Path, name: String) = Files.write(Paths.get(path.toString() + "/$name.component.js"), Strings.jsFile(name).split("\n").toList())

fun createHtmlFile(path: Path, name: String, electron: Boolean) {
    if(electron)
        Files.write(Paths.get(path.toString() + "/$name.component.html"), Strings.exampleHtmlElectron(name).split("\n").toList())
    else
        Files.write(Paths.get(path.toString() + "/$name.component.html"), Strings.exampleHtml(name).split("\n").toList())
}

fun createCssFile(path: Path, name: String) = Files.write(Paths.get(path.toString() + "/$name.component.css"), Strings.exampleCss(name).split("\n").toList())

fun importComponent(name: String) = File(System.getProperty("user.dir") + "/src/main.js").appendText("import $name from './components/$name/$name.component.js'\n")