# Install the Vendor Palm SDK

The palm scan feature needs the **Veinshine/Eyecool Palm Android SDK**. The app shows "Vendor SDK not installed" until the SDK JAR and native libraries are in place.

## 1. Get the SDK

The SDK is **not** included in this repo. You need it from:

- **Hardware vendor**: Often provided with the Eyecool palm scanner device (e.g. USB device 735f:6204).
- **Contact**: Your device supplier or Veinshine/Eyecool support for the Android SDK package.

The expected package is a zip such as **`palm-android-sdk-v1.3.14-L.zip`** (or similar version) that contains:

- `libs/palm-android-sdk-v1.3.14.jar` (or same version in the name)
- `libs/arm64-v8a/*.so` (native libraries for 64-bit ARM)
- Optionally `libs/armeabi-v7a/*.so` (32-bit ARM)

If you receive a different zip (e.g. different version or layout), see **Manual install** below.

## 2. Install via script (recommended)

From your **computer** (not the device), in a terminal:

1. **Open the terminal-android project root** (the folder that contains `app/` and `scripts/`):

   ```bash
   cd /Users/samuelomondi/AndroidStudioProjects/PalmTestApp/Android/farm-to-palm/terminal-android
   ```

2. **Run the install script** with the **full path** to your SDK zip (or to the unzipped folder):

   ```bash
   ./scripts/install_vendor_sdk.sh /path/to/palm-android-sdk-v1.3.14-L.zip
   ```

   Example if the zip is in Downloads:

   ```bash
   ./scripts/install_vendor_sdk.sh ~/Downloads/palm-android-sdk-v1.3.14-L.zip
   ```

   If you already unzipped it:

   ```bash
   ./scripts/install_vendor_sdk.sh ~/Downloads/palm-android-sdk-v1.3.14-L
   ```

3. **Sync Gradle** in Android Studio (File → Sync Project with Gradle Files) or:

   ```bash
   ./gradlew assembleDebug
   ```

4. **Rebuild and reinstall** the app on your device. The "Vendor SDK not installed" banner should disappear and palm scan should work (with the scanner connected and USB permission granted).

## 3. Verify install

From `terminal-android`:

```bash
ls -la app/libs
ls -la app/src/main/jniLibs/arm64-v8a
```

You should see:

- `app/libs/palm-android-sdk-v1.3.14.jar` (or the JAR name from your SDK)
- Several `*.so` files in `app/src/main/jniLibs/arm64-v8a/`

## 4. Manual install (if your SDK zip has a different structure)

If the script fails (e.g. different version or paths), do this manually:

1. **JAR**  
   Copy the SDK’s single JAR (something like `palm-android-sdk-*.jar`) into:

   ```
   terminal-android/app/libs/
   ```

2. **Native libs**  
   Copy all `*.so` files for **arm64-v8a** from the SDK into:

   ```
   terminal-android/app/src/main/jniLibs/arm64-v8a/
   ```

   Create the folder if it doesn’t exist. If the SDK also has **armeabi-v7a**, copy those `*.so` into:

   ```
   terminal-android/app/src/main/jniLibs/armeabi-v7a/
   ```

3. Sync Gradle and rebuild the app.

## 5. If you don’t have the SDK yet

- Use **NFC** for attendance/meals if your setup supports it.
- Request the Android SDK from your scanner vendor (e.g. Veinshine/Eyecool or your device supplier). Mention you need the **Android** SDK with **JAR + arm64-v8a .so** for the palm terminal app.

After a correct install, the app will detect the SDK on startup and palm scan will stop showing "Vendor SDK not installed".

---

## Troubleshooting

### Scanner not working / not blinking after opening the app

**Symptom:** SDK is installed, app runs, but the palm scanner device does not activate (no LED blink, scan does nothing).

**Cause:** The device open flow must pass a **real** Java object that implements the vendor’s `com.api.stream.IOpenCallback` to `Device.open()`. If the code uses a **dynamic Proxy** (e.g. to avoid compiling against the JAR), the native SDK can behave incorrectly and the scanner never opens.

**Fix:**

1. **VeinshineOpenCallback.kt**  
   - Implement the vendor interface directly: `class VeinshineOpenCallback(...) : IOpenCallback`  
   - Add: `import com.api.stream.IOpenCallback`  
   - Do **not** implement a local stub (e.g. `IOpenCallbackStub`) and do not pass a Proxy to the SDK.

2. **VeinshinePalmSdk.kt**  
   - Resolve the open method with the real interface:  
     `device.javaClass.getMethod("open", com.api.stream.IOpenCallback::class.java)`  
   - Pass the real callback instance:  
     `openMethod.invoke(device, openCallback)`  
   - Do **not** create a `Proxy.newProxyInstance(...)` and do not pass the proxy to `invoke(device, proxy)`.

**Requirement:** The vendor JAR must be on the classpath at **compile** time (e.g. in `app/libs/` after running `install_vendor_sdk.sh`). Without it, the project will not compile when using the real `IOpenCallback`.

**Quick reference:** See `SCANNER_CALLBACK_FIX.md` in this directory for the same fix in short form.
