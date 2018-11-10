# Es6ComponentsManager
Es6 Web-Components-Manager with webpack, browsersync and optional electron

There are 2 programs in this project.

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
Generates a project of the folling structure:
├ src/

│ ├ components/ // places every new generated component here
│ ├ dist/       // webpack places here the generated js file
│ ├ index.html
│ ├ main.js     // registeres every component automatically here
│ └ styles.css
│
├ index.js (if electron was selected)
├ package.json  // commands are already predefined
└ webpack.config.js

### Parameter: [-e] [projectname]
(you can put them in any order)

-e: generates you an electron app (is important for the browsersync script)

projectname: no constraints

### Example
java -jar CreateWebProject.jar TestMeWithElectron -e

## CreateWebComponent
### Results
Generates a 3 files for a webcomponent under the components/ folder and registers the component automatically in the main.js of the project. (command needs to be run the root folder)
└ components
  └ newComponent
    ├ newComponent.component.js
    ├ newComponent.component.css
    └ newComponent.component.html
    
### Parameter
You need to pass a name for the component.
There are the same constraint as for a javascript-class-name. It won't display you any errors, just the javascript engine and webpack will tell that there is something wrong
