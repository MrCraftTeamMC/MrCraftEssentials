> [!CAUTION]
> Still in early stages of development, expect forced pushes and breaking changes! 
> 
> See the wiki page before using this mod.
> 
> You can use [Essential Commands Mod](https://github.com/John-Paul-R/Essential-Commands) instead.

**English** | [中文](./readme_cn.md)

# Mr Craft Essentials Mod

[![Java Version](https://img.shields.io/badge/jdk-17.0.9+-brighgreen.svg?colorB=469C00&logo=java)](https://adoptium.net/temurin/releases/?version=17)
[![Gradle Version](https://img.shields.io/badge/Gradle-8.3-brightgreen.svg?colorB=469C00&logo=gradle)](https://docs.gradle.org/8.3/release-notes.html)
[![GitHub Workflow Status (with event)](https://img.shields.io/github/actions/workflow/status/MrCraftTeamMC/MrCraft-Essentials/build.yml)](./.github/workflows/build.yml)
[![GitHub release (with filter)](https://img.shields.io/github/v/release/MrCraftTeamMC/MrCraft-Essentials)](https://github.com/MrCraftTeamMC/MrCraft-Essentials/releases)
[![GitHub all releases Downloads](https://img.shields.io/github/downloads/MrCraftTeamMC/MrCraft-Essentials/total)](https://github.com/MrCraftTeamMC/MrCraft-Essentials/releases)

## Introduce

This mod is a fabric version of plugin [`EssentialsX`](https://github.com/EssentialsX/Essentials) (Probably / A Part).

> [!IMPORTANT]
> **For more details, Please see [our wiki](https://github.com/MrCraftTeamMC/MrCraft-Essentials/wiki/).**

Please help improve our wiki too!

## Minecraft Version Support

| Version | Status         | Latest Version  |
|---------|----------------|-----------------|
| 1.21.x  | Unavailable ❌  | N/A             |
| 1.20.x  | Active (WIP) ✅ | 1.0-SNAPSHOT-01 |
| 1.19.x  | Making ⚙️      | N/A             |
| 1.18.x  | Holding 🛠️    | N/A             |
| 1.17.x  | Holding 🛠️    | N/A             |
| 1.16.x  | Holding 🛠️    | N/A             |
| 1.15.x  | Holding 🛠️    | N/A             |
| 1.14.x  | Holding 🛠️    | N/A             |
| 1.13.x  | No Plan ❌      | N/A             |

## Dependencies

| Dependency (Mod) | Loader                                            | Type     | Version (Recommend the Latest Version) | Download (Links)                                                                                                                                                                                   |
|------------------|---------------------------------------------------|----------|----------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Fabric API       | Fabric **(Quilt Loader use QSL / QFAPI instead)** | Required | Any                                    | [CurseForge](https://www.curseforge.com/minecraft/mc-mods/fabric-api) &#124; [Modrinth](https://modrinth.com/mod/fabric-api) &#124; [Github](https://github.com/FabricMC/fabric)                   |
| Carpet           | Fabric                                            | Optional | Any                                    | [CurseForge](https://www.curseforge.com/minecraft/mc-mods/carpet) &#124; [Modrinth](https://www.curseforge.com/minecraft/mc-mods/carpet) &#124; [Github](https://github.com/gnembon/fabric-carpet) |

## Configuring and Rules

Please see [our wiki](https://github.com/MrCraftTeamMC/MrCraft-Essentials/wiki/).

## Building

> [!WARNING]
> This project is still WIP. The Artifacts may not be generated by Gradle.

1. Download Repository Zip and Unzip it.
2. run command:
    ```shell
    ./gradlew clean build # For Non-Windows
    
    .\gradlew.bat clean build # For Windows
    ```
3. The artifacts jar will be in the `build/libs` folder.

## Developing and Contributing

Welcome you to Fork this project and Submit your PR. [(More information here)](https://github.com/MrCraftTeamMC/MrCraft-Essentials/wiki/)

> [!TIP]
> If you are Players, we suggest you to Find bugs and Create issues.

## License

This project is available under the LGPLv3 license. Feel free to learn from it and incorporate it in your own projects.