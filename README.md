# BitByte 🤖

BitByte is a lightweight Discord bot built in **Java** using the [JDA](https://github.com/DV8FromTheWorld/JDA) library.

This project is in its early stages and currently supports a single test command.

---

## ✨ Features

- `Welcome message` → Sends a welcome message to new members
- `Auto-role on join` → Automatically assigns one or multiple roles to new members

## 📜 Commands

- `/Bhelp` → Replies with a list of command
- `/Bping` → Replies with `pong!`
- `/Buserinfo` → Displays information about you or a mentioned user
- `/Bclear` → Deletes a specified number of messages (admin only)
- `/Bavatar` → Shows the avatar of yourself or a mentioned user in high resolution
- `/Bservericon` → Shows the server icon in high resolution (1024px)
- `/Bremind <seconds> <message>` → Schedules a reminder and pings you when it’s due

More utilities and fun commands coming soon!

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or newer
- [Maven](https://maven.apache.org/)
- A Discord bot token (from the [Discord Developer Portal](https://discord.com/developers/applications))

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/devfavian/BitByte.git
   cd BitByte

2. Open the project in your favorite IDE (e.g. Eclipse or IntelliJ).

3. Replace the placeholder with your actual Discord bot token inside Main.java:
   'JDABuilder.createDefault("YOUR_DISCORD_BOT_TOKEN")'

4. Run the bot by launching the Main class.


---
### License

No license specified yet. You are free to use, modify, and contribute for now.




---
## 🎯 Italiano

BitByte è un bot Discord scritto in Java con la libreria JDA.

## ✨ Features

- `Welcome message` → Invia un messaggio di benvenuto ai nuovi arrivati
- `Auto-role on join` → Assegna automaticamente uno o più ruoli ai nuovi arrivati

## 📜 Commands

- `/Bhelp` → Risponde la lista di comandi di ByteBot
- `/Bping` → Risponde con `pong!`
- `/Buserinfo` → Mostra informazioni su di te o su un'altro utente
- `/Bclear` → Elimina una certa quantità di messaggi (solo admin)
- `/Bavatar` → Mostra il tuo avatar o quello di un'altro utente in alta risoluzione (1024px)
- `/Bservericon` → Mostra l'icona del server in alta risoluzione (1024px)
- `/Bremind <seconds> <message>` → Imposta un promemoria

# 🚀 Esecuzione

1. Clona il repository

2. Inserisci il tuo token Discord nel file Main.java

3. Esegui il bot da Main

Il progetto è in sviluppo, verranno aggiunte nuove funzioni presto!