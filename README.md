# Es6ComponentsManager
Es6 Web-Components-Manager with webpack, browsersync and optional electron

There are 2 programs in this project (you can just download jars).

1. CreateWebProject
2. CreateWebComponent

To use this you need to have browsersync installed (https://browsersync.io/)

## Use the whole power
run the following commands in different terminal windows
1. npm run build
2. npm run bsync (or npm run bsync_electron if electron was selected)
3. npm start (only if electron was selected)

## CreateWebProject
### Results
Generates a project with the folling structure:
```bash
├ src/
│ ├ components/ // places every new generated component here
│ ├ dist/       // webpack places the generated js file here
│ ├ index.html
│ ├ main.js     // registeres every component automatically here
│ └ styles.css
│
├ index.js      // if electron was selected
├ package.json  // commands are already predefined
└ webpack.config.js
```

### Parameter: [-e] [projectname]
(you can put them in any order)

-e: generates an electron app (important for the browsersync script)

projectname: no constraints

### Example
java -jar CreateWebProject.jar TestMeWithElectron -e

## CreateWebComponent
### Results
Generates 3 files for a webcomponent underneath components/ and registers the component automatically in the main.js of the project. (command needs to be run in the root folder)
```bash
└ components
  └ newComponent
    ├ newComponent.component.js
    ├ newComponent.component.css
    └ newComponent.component.html
```
    
### Parameter
You need to pass a name for the component.
There are the same constraints as for a javascript-class-name. It won't display any errors, only the javascript engine and webpack will tell that there is something wrong

### Example
java -jar CreateWebComponent.jar NewComponent
