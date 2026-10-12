# Donut HUD — GitHub Actions build

Fabric client-side HUD for Minecraft Java 1.21.11. Displays coordinates, direction, FPS, and dimension.

## Build the JAR on GitHub

1. Create a repository at https://github.com/new (for example, `DonutHUD`).
2. Upload **all the files and folders inside this project**, including the hidden `.github` folder. Do not upload only the ZIP file.
   - Easiest method: install GitHub Desktop from https://desktop.github.com/, then add this extracted folder as a local repository and publish it.
   - Or on the repository page choose **Add file → Upload files**, drag the extracted project contents into the page, then commit the upload.
3. Open your repository on GitHub and select the **Actions** tab.
4. Choose **Build Donut HUD** in the workflows list. If it is not listed yet, make sure `.github/workflows/build.yml` was uploaded to that exact path.
5. Click **Run workflow** → **Run workflow**. A push to the repository also starts a build automatically.
6. Open the running workflow, wait for it to finish, then click the completed run.
7. Under **Artifacts**, click **DonutHUD-JAR** to download the generated ZIP containing the `.jar` file.
8. Extract that downloaded artifact ZIP. Copy the `.jar` into `%appdata%\.minecraft\mods`. Use Fabric Loader and Fabric API compatible with Minecraft 1.21.11.

## Notes

GitHub Actions compiles the source; it does not make incorrect source code compile automatically. If the workflow fails, open the failed run and expand the **Build mod JAR** step, then use the error log to fix the source or dependency versions. This project has not been verified by a successful build in this environment.
