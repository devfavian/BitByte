# BitByte 🤖

BitByte is a lightweight Discord bot built in **Java** using the [JDA](https://github.com/DV8FromTheWorld/JDA) library.  
Originally created as a learning project, it now includes several useful moderation and utility commands.

> **Project status:** 🟢 **Stable** • ⚠️ **Maintenance mode** — Active development has slowed down as I’m focusing on other projects.  
> The bot is still hosted on a private VPS and fully functional. You can [invite it to your server](https://discord.com/oauth2/authorize?client_id=1403010360847630336&permissions=8&integration_type=0&scope=applications.commands+bot) or contact me for upgrades, tips, or issue reports.

---

## ✨ Features

- **Welcome message** → Sends a welcome message to new members  
- **Auto-role on join** → Automatically assigns one or multiple roles to new members  
- **Moderation tools** → `/clear`, `/userinfo`, etc.  
- **Utility commands** → `/avatar`, `/servericon`, `/remind`, etc.  

---

## 📜 Command format

- ``<arg>`` = required argument → the command will not work without it.

- ``[arg]`` = optional argument → can be omitted; the command will use a default value if not provided.

## 📜 Commands

- ``/help`` → Displays a list of all available commands  
- ``/ping`` → Replies with `pong!`  
- ``/userinfo [user]`` → Shows information about yourself or another user  
- ``/clear <amount>`` → Deletes a specified number of messages (**admin only**)  
- ``/avatar [user]`` → Shows your avatar or another user’s avatar in high resolution (1024px)  
- ``/servericon`` → Shows the server icon in high resolution (1024px)  
- ``/remind <seconds> <message>`` → Schedules a reminder and pings you when it’s due  

---

## 🚀 Getting Started

### Prerequisites
- Java **21** or newer
- [Maven](https://maven.apache.org/)
- A Discord bot token (from the [Discord Developer Portal](https://discord.com/developers/applications))

### Setup

1. **Clone the repository**

2. Open the project in your favorite IDE (e.g. Eclipse or IntelliJ).

3. Replace the placeholder with your actual Discord bot token inside Main.java:
   'JDABuilder.createDefault("YOUR_DISCORD_BOT_TOKEN")'

4. Run the bot by launching the Main class.


---
### License

No license specified yet. You are free to use, modify, and contribute for now.



---


## 🎯 Italiano

BitByte è un bot Discord scritto in **Java** con la libreria [JDA](https://github.com/DV8FromTheWorld/JDA).  
Nato come progetto di apprendimento, ora include diversi comandi utili di moderazione e gestione.

> **Stato progetto:** 🟢 **Stabile** • ⚠️ **Modalità manutenzione** — Lo sviluppo attivo è rallentato per concentrarmi su altri progetti.  
> Il bot è ancora ospitato su una VPS privata ed è completamente funzionante. Puoi [invitarlo nel tuo server](https://discord.com/oauth2/authorize?client_id=1403010360847630336&permissions=8&integration_type=0&scope=applications.commands+bot) o contattarmi per aggiornamenti, consigli o segnalazioni.

---

### ✨ Funzionalità

- **Messaggio di benvenuto** → Invia un messaggio ai nuovi arrivati  
- **Auto-assegnazione ruoli** → Assegna automaticamente uno o più ruoli ai nuovi membri  
- **Strumenti di moderazione** → `/clear`, `/userinfo`, ecc.  
- **Comandi di utilità** → `/avatar`, `/servericon`, `/remind`, ecc.  

---

### 📜 Comandi

- ``/help`` → Mostra la lista di tutti i comandi disponibili  
- ``/ping`` → Risponde con `pong!`  
- ``/userinfo []`` → Mostra informazioni su di te o su un altro utente  
- ``/clear <quantità>`` → Elimina un certo numero di messaggi (**solo admin**)  
- ``/avatar [utente]`` → Mostra il tuo avatar o quello di un altro utente in alta risoluzione (1024px)  
- ``/servericon`` → Mostra l’icona del server in alta risoluzione (1024px)  
- ``/remind <secondi> <messaggio>`` → Imposta un promemoria  

---

### 🚀 Esecuzione

1. Clona il repository

2. Inserisci il tuo token Discord nel file Main.java

3. Esegui il bot da Main