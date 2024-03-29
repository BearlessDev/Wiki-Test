# LobbyManager v1.0

### Description:
LobbyManager is a plugin that allows you to easily configure your server lobby just through a single configuration file that is easy to understand and modify.

## Commands:
- /lm-reload or /lobbymanager-reload:
    - Allows you to reload the configuration file after modifying it to avoid restarting the entire server.
- /lm-spawn, /lobbymanager-spawn or /spawn:
  - Allows you to go back to the spawn set on the config.yml file.

## Permissions:
- Reload Command:
    - Default permission is: "lobbymanager.commands.reload" but you can change it on the config.yml file.
- Spawn Command:
  - This command don't require permission.

## Configuration file:
Here the config file of the plugin:

```Yaml
#    _          _     _           __  __
#   | |    ___ | |__ | |__  _   _|  \/  | __ _ _ __   __ _  __ _  ___ _ __
#   | |   / _ \| '_ \| '_ \| | | | |\/| |/ _` | '_ \ / _` |/ _` |/ _ \ '__|
#   | |__| (_) | |_) | |_) | |_| | |  | | (_| | | | | (_| | (_| |  __/ |
#   |_____\___/|_.__/|_.__/ \__, |_|  |_|\__,_|_| |_|\__,_|\__, |\___|_|
#                           |___/                          |___/           
# By Bearless
# Version: 1.0
#
#
# LobbyManager Placeholder:
#
# %player% --> return the name of the player.
#
#

usage-message:
  reload: "&c&lIncorrect Usage: &c/lm-reload &c&lor &c/lobbymanager-reload" #Message when you do the wrong reload command.

server:
  disable_default_join_message: true #Disable the default join message "Bearless_ joined the game".
  disable_default_quit_message: true #Disable the default quit message "Bearless_ quit the game".

  custom_join_message: "&a%player% &ejoin the lobby!" #Replace the default join message by a custom one.
  custom_quit_message: "&a%player% &equit the lobby!" #Replace the default quit message by a custom one.

world:
  block-break:
    enable: true #Disable the ability for the players to break block.
    permission: "lobbymanager.block.break" #The permission needed to break block.
    permission-message: "&cSorry, but you can't break block." #The message who appear when a player try to break a block without the permission.

  block-place:
    enable: true #Disable the ability for the players to place block.
    permission: "lobbymanager.block.place" #The permission needed to place block.
    permission-message: "&cSorry, but you can't place block." #The message who appear when a player try to place a block without the permission.

  disable-entity-spawn: true #Disable the spawn of entity (Passive and Aggressive) like (Pig, Creeper, Zombie, Cow etc...).
  disable-weather-change: true #Disable the change of the weather.

  enable_join_player_spawn_loc: true #enable or disable the custom spawn for player while joining the server.
  spawn_world_name: "world" #The name of the world where the spawn will be set.
  spawn_X: 0 #The X position of the custom spawn.
  spawn_Y: 65 #The Y position of the custom spawn.
  spawn_Z: 0 #The Z position of the custom spawn.
  spawn_Yaw: 180 #The YAW position of the custom spawn.
  spawn_Pitch: 0 #The PITCH position of the custom spawn.

  spawn_teleport_onFall: 5 #When a player falls into the void, that position Y will be the point where the player will be teleported to the custom spawn.

player:
  disable_fall_damage: true #Preventing player from taking fall damage.
  disable_food_loss: true #Preventing player from lost food.

  player_health_level: 20 #Set the health of the player when joining the server.
  player_food_level: 20 #Set the food of the player when joining the server.

  enable_player_gamemode: true #Enable or Disable the gamemode of the player when joining the server.
  set_player_gamemode: "adventure" #The gamemode will be set to the player when joining the server.

commands: #List of all the Permission/Message of all the plugin command.
  reload:
    permission: "lobbymanager.commands.reload" #The permission to do /lm-reload.
    permission-message: "&cYou don't have the required permission." #The message will be sent to the player who perform the command without the right permission.
    reload-message: "&aThe configuration file have been reloaded." #The message send when the command successfully done.
  spawn:
    spawn_message: "§aYou have been teleported to the spawn."
```

## The Discord
If you need help you can join the community server, and we will help you.

Discord: <a href="https://discord.gg/BpfRew4aR6">https://discord.gg/BpfRew4aR6</a>

[![forthebadge](data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxNDMuOTY4NzcyODg4MTgzNiIgaGVpZ2h0PSIzNSIgdmlld0JveD0iMCAwIDE0My45Njg3NzI4ODgxODM2IDM1Ij48cmVjdCB3aWR0aD0iODcuOTY4NzY1MjU4Nzg5MDYiIGhlaWdodD0iMzUiIGZpbGw9IiM0NTQ1NDUiLz48cmVjdCB4PSI4Ny45Njg3NjUyNTg3ODkwNiIgd2lkdGg9IjU2LjAwMDAwNzYyOTM5NDUzIiBoZWlnaHQ9IjM1IiBmaWxsPSIjMTgwOGQ3Ii8+PHRleHQgeD0iNDMuOTg0MzgyNjI5Mzk0NTMiIHk9IjIxLjUiIGZvbnQtc2l6ZT0iMTIiIGZvbnQtZmFtaWx5PSInUm9ib3RvJywgc2Fucy1zZXJpZiIgZmlsbD0iI2ZmZmZmZiIgdGV4dC1hbmNob3I9Im1pZGRsZSIgbGV0dGVyLXNwYWNpbmc9IjIiPlZFUlNJT048L3RleHQ+PHRleHQgeD0iMTE1Ljk2ODc2OTA3MzQ4NjMzIiB5PSIyMS41IiBmb250LXNpemU9IjEyIiBmb250LWZhbWlseT0iJ01vbnRzZXJyYXQnLCBzYW5zLXNlcmlmIiBmaWxsPSIjRkZGRkZGIiB0ZXh0LWFuY2hvcj0ibWlkZGxlIiBmb250LXdlaWdodD0iOTAwIiBsZXR0ZXItc3BhY2luZz0iMiI+MS4xMDwvdGV4dD48L3N2Zz4=)](https://forthebadge.com)