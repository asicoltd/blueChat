
# BlueChat

**BlueChat** is a Bluetooth-based messaging application that allows users to create groups, send personal and broadcast messages, and manage communication without an internet connection.

## Features

- **Create Groups**: Public and Private group creation with PIN protection.
- **Personal Messaging**: One-to-one chat functionality.
- **Broadcast Messaging**: Send messages to multiple users at once.
- **Group Listing**: View available groups with member count and delay information.
- **Countdown Timer**: Auto-disconnect or notification system based on a timer.
- **User Interface Options**: Theme selection, Bluetooth reset, and algorithm choices for connection handling.

## Screenshots

*(Add relevant screenshots here.)*

## Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/yourusername/BlueChat.git
   cd BlueChat
   ```

2. Open the project in **Android Studio**.

3. Build and run the app on a physical device (Bluetooth functionality may not work on emulators).

## Project Structure

```
📂 BlueChat/
├── 📁 app/src/main/java/com/ewubd/bluechat/
│   ├── MainActivity.java
│   ├── ChatActivity.java
│   ├── BroadcastMessageActivity.java
│   ├── CreateGroupActivity.java
│   ├── GroupListActivity.java
│   ├── PersonalMessageActivity.java
│   ├── OptionsActivity.java
│   ├── AboutActivity.java
│   ├── (Other Java classes)
│
├── 📁 app/src/main/res/layout/
│   ├── activity_main.xml
│   ├── activity_chat.xml
│   ├── activity_create_group.xml
│   ├── activity_group_list.xml
│   ├── activity_personal_message.xml
│   ├── activity_options.xml
│   ├── activity_about.xml
│
├── 📁 app/src/main/res/drawable/
│   ├── incoming_message_bg.xml
│   ├── outgoing_message_bg.xml
│
├── 📁 app/src/main/res/values/
│   ├── strings.xml
│   ├── colors.xml
│   ├── themes.xml
│
└── README.md
```

## Usage

1. **Launch the App**.
2. **Create or Join a Group**.
3. **Send Messages** to individuals or broadcast to a group.
4. **Modify Settings** from the Options menu.

## Dependencies

Ensure you have the following dependencies in `build.gradle`:

```gradle
dependencies {
    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'com.google.android.material:material:1.4.0'
}
```

## Future Improvements

- **Bluetooth Mesh Networking** for better connectivity.
- **End-to-End Encryption** for private conversations.
- **File Transfer Support** over Bluetooth.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
