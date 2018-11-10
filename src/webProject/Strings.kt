package webProject

class Strings {
    companion object {
        fun indexHtml(name: String) = "<html>\n" +
                "    <head>\n" +
                "        <title>[title]</title>\n" +
                "\n" +
                "\t\t<link rel=\"stylesheet\" href=\"styles.css\">\n" +
                "\t\t<script src=\"dist/bundle.js\"></script>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "\t\t<h1>" + name + "</h1>\n" +
                "\n" +
                "    </body>\n" +
                "</html>\n"

        fun indexHtmlWithElectron(name: String) = "<html>\n" +
                "    <head>\n" +
                "        <title>[title]</title>\n" +
                "\n" +
                "\t\t<link rel=\"stylesheet\" href=\"styles.css\">\n" +
                "\t\t<script src=\"dist/bundle.js\"></script>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "\t\t<h1>" + name + "</h1>\n" +
                "\n" +
                "\t\t<script async id=\"__bs_script__\" src=\"http://localhost:3000/browser-sync/browser-sync-client.js?v=2.18.8 \"></script>" +
                "    </body>\n" +
                "</html>\n"

        fun indexJs() = "const { app, BrowserWindow } = require('electron')\n" +
                "  \n" +
                "  // Behalten Sie eine globale Referenz auf das Fensterobjekt. \n" +
                "  // Wenn Sie dies nicht tun, wird das Fenster automatisch geschlossen, \n" +
                "  // sobald das Objekt dem JavaScript-Garbagekollektor übergeben wird.\n" +
                "  \n" +
                "  let win\n" +
                "  \n" +
                "  function createWindow () {\n" +
                "    // Erstellen des Browser-Fensters.\n" +
                "    win = new BrowserWindow({ width: 800, height: 600 })\n" +
                "  \n" +
                "    // und Laden der index.html der App.\n" +
                "    win.loadFile('./src/index.html')\n" +
                "  \n" +
                "    // Öffnen der DevTools.\n" +
                "    win.webContents.openDevTools()\n" +
                "  \n" +
                "    // Ausgegeben, wenn das Fenster geschlossen wird.\n" +
                "    win.on('closed', () => {\n" +
                "      // Dereferenzieren des Fensterobjekts, normalerweise würden Sie Fenster\n" +
                "      // in einem Array speichern, falls Ihre App mehrere Fenster unterstützt. \n" +
                "      // Das ist der Zeitpunkt, an dem Sie das zugehörige Element löschen sollten.\n" +
                "      win = null\n" +
                "    })\n" +
                "  }\n" +
                "  \n" +
                "  // Diese Methode wird aufgerufen, wenn Electron mit der\n" +
                "  // Initialisierung fertig ist und Browserfenster erschaffen kann.\n" +
                "  // Einige APIs können nur nach dem Auftreten dieses Events genutzt werden.\n" +
                "  app.on('ready', createWindow)\n" +
                "  \n" +
                "  // Verlassen, wenn alle Fenster geschlossen sind.\n" +
                "  app.on('window-all-closed', () => {\n" +
                "    // Unter macOS ist es üblich für Apps und ihre Menu Bar\n" +
                "    // aktiv zu bleiben bis der Nutzer explizit mit Cmd + Q die App beendet.\n" +
                "    if (process.platform !== 'darwin') {\n" +
                "      app.quit()\n" +
                "    }\n" +
                "  })\n" +
                "  \n" +
                "  app.on('activate', () => {\n" +
                "    // Unter macOS ist es üblich ein neues Fenster der App zu erstellen, wenn\n" +
                "    // das Dock Icon angeklickt wird und keine anderen Fenster offen sind.\n" +
                "    if (win === null) {\n" +
                "      createWindow()\n" +
                "    }\n" +
                "  })\n" +
                "  \n" +
                "  // In dieser Datei können Sie den Rest des App-spezifischen \n" +
                "  // Hauptprozess-Codes einbinden. Sie können den Code auch \n" +
                "  // auf mehrere Dateien aufteilen und diese hier einbinden."

        fun webpackConf() = "const path = require(\"path\");\n" +
                "\n" +
                "module.exports = {\n" +
                "\tentry: \"./src/webProject.webComponent.main.js\",\n" +
                "\toutput: {\n" +
                "\t\tfilename: \"bundle.js\",\n" +
                "\t\tpath: path.resolve(__dirname + \"/src\", 'dist')\n" +
                "\t},\n" +
                "\n" +
                "\tmodule: {\n" +
                "\t\trules: [\n" +
                "\t\t\t{\n" +
                "\t\t\t\ttest: /\\.css\$/,\n" +
                "\t\t\t\tuse: ['css-loader']\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\ttest: /\\.html\$/,\n" +
                "\t\t\t\tuse: ['html-loader']\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t}\n" +
                "}"

        fun packageJson(name: String) = "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"version\": \"1.0.0\",\n" +
                "  \"description\": \"\",\n" +
                "  \"webProject.webComponent.main\": \"index.js\",\n" +
                "  \"scripts\": {\n" +
                "    \"test\": \"echo \\\"Error: no test specified\\\" && exit 1\",\n" +
                "    \"bsync\": \"browser-sync src src -f src --cors -b \\\"google chrome\\\" --no-notify\",\n" +
                "    \"build\": \"webpack -p --watch\"\n" +
                "  },\n" +
                "  \"author\": \"\",\n" +
                "  \"license\": \"ISC\",\n" +
                "  \"dependencies\": {\n" +
                "    \"css-loader\": \"^1.0.1\",\n" +
                "    \"html-loader\": \"^0.5.5\",\n" +
                "    \"webpack\": \"^4.25.1\"\n" +
                "  },\n" +
                "  \"devDependencies\": {\n" +
                "    \"webpack-cli\": \"^3.1.2\"\n" +
                "  }\n" +
                "}\n"

        fun packageJsonElectron(name: String) = "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"version\": \"1.0.0\",\n" +
                "  \"description\": \"\",\n" +
                "  \"webProject.webComponent.main\": \"index.js\",\n" +
                "  \"scripts\": {\n" +
                "    \"test\": \"echo \\\"Error: no test specified\\\" && exit 1\",\n" +
                "    \"bsync\": \"browser-sync src src -f src --cors -b \\\"google chrome\\\" --no-notify\",\n" +
                "    \"bsync_electron\": \"browser-sync start --localOnly --files './src'\",\n" +
                "    \"build\": \"webpack -p --watch\",\n" +
                "    \"start\": \"electron .\"\n" +
                "  },\n" +
                "  \"author\": \"\",\n" +
                "  \"license\": \"ISC\",\n" +
                "  \"dependencies\": {\n" +
                "    \"css-loader\": \"^1.0.1\",\n" +
                "    \"electron\": \"^3.0.8\",\n" +
                "    \"html-loader\": \"^0.5.5\",\n" +
                "    \"webpack\": \"^4.25.1\"\n" +
                "  },\n" +
                "  \"devDependencies\": {\n" +
                "    \"webpack-cli\": \"^3.1.2\"\n" +
                "  }\n" +
                "}\n"
    }
}