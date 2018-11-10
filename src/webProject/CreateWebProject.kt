package webProject

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {

    var homefolder = File(System.getProperty("user.dir"))
    val electron = isElectronWanted(args)

    //one parameter is passed and it was not -e
    if(args.size == 1 && !electron) {
        createHomeFolder(args[0])
        homefolder = File(System.getProperty("user.dir") + "/" + args[0])
    }
    else if(args.size > 1 && electron) {
        homefolder = File(System.getProperty("user.dir") + "/" + args[getName(args)])
    }

    println("creating project at " + homefolder.path)
    createBaseStructure(homefolder, electron)
    install(homefolder)
}

fun createHomeFolder(name: String) {
    Files.createDirectory(Paths.get(System.getProperty("user.dir") + "/" + name))
}

fun createBaseStructure(dir: File, electron: Boolean) {
    val name = dir.path.split("/").last()

    createSrc(dir, name, electron)
    createPackageJson(dir, name, electron)

    Files.write(Paths.get(dir.path + "/webpack.config.js"), Strings.webpackConf().split("/n").toList())
}

fun createPackageJson(dir: File, name: String, electron: Boolean) {
    val packageJson = Files.createFile(Paths.get(dir.path + "/package.json"))
    if(electron)
        Files.write(packageJson, Strings.packageJsonElectron(name).split("\n").toList())
    else
        Files.write(packageJson, Strings.packageJson(name).split("\n").toList());
}

fun createSrc(dir: File, name: String, electron: Boolean) {
    Files.createDirectories(Paths.get(dir.path + "/src/components"))

    createIndexHtml(dir, name, electron)
    Files.createFile(Paths.get(dir.path + "/src/main.js"))
    Files.createFile(Paths.get(dir.path + "/src/styles.css"))

    if(electron)
        Files.write(Files.createFile(Paths.get(dir.path + "/index.js")), Strings.indexJs().split("\n").toList())
}

fun createIndexHtml(dir: File, name: String, electron: Boolean) {
    if(electron)
        Files.write(Files.createFile(Paths.get(dir.path + "/src/index.html")), Strings.indexHtmlWithElectron(
            name
        ).split("\n").toList())
    else
        Files.write(Files.createFile(Paths.get(dir.path + "/src/index.html")), Strings.indexHtml(name).split("\n").toList())
}

fun isElectronWanted(args: Array<String>) : Boolean {
    for(s in args) {
        if(s == "-e")
            return true
    }
    return false;
}

fun indexOfElectron(args: Array<String>) : Int {
    for(i in args.indices) {
        if(args[i] == "-e")
            return i
    }
    return -1
}

fun getName(args: Array<String>) : Int{
    for(i in args.indices) {
        if(!(args[i][0] == '-'))
            return i
    }
    return -1
}

fun install(dir: File) {
    println("installing npm dependencies...")
    Runtime.getRuntime().exec("npm i", null, dir).waitFor()
}