# Device shows white screen

## 1. You must run the **terminal-android** app, not the template app

This repo has two different Android apps:

| Project folder | What it is | What you see when you run it |
|----------------|------------|------------------------------|
| **Android** (root) | Default template with `:app` | Often a **white or empty screen** |
| **Android/farm-to-palm/terminal-android** | FarmToPalm terminal (Activation, Home, palm scan) | Activation screen → Home |

**Fix:** In Android Studio, **File → Open** and choose:

```
Android/farm-to-palm/terminal-android
```

Open the **terminal-android** folder (so it is the project root). Sync Gradle, then Run on your device. You should see the **Activation** screen (Base URL, activation code, Test connection, Activate).

Do **not** open the parent **Android** folder and run from there — that runs the wrong app.

---

## 2. Check Logcat for crashes

If you are sure you opened **terminal-android** and still get a white screen:

1. In Android Studio: **View → Tool Windows → Logcat**.
2. Select your device and the app `com.farmtopalm.terminal`.
3. Run the app and watch for **red** error lines when the white screen appears.
4. Share the stack trace (the first few lines of the exception) to debug (e.g. Room, Crypto, or Palm SDK init).

---

## 3. Rebuild and reinstall

- **Build → Clean Project**, then **Build → Rebuild Project**.
- **Run** again on the device (or **Run → Run 'app'**).

---

## 4. Summary

- **Correct project to open:** `Android/farm-to-palm/terminal-android`
- **Wrong project:** `Android` (root) — this is the one that gives a white screen when you run it.
