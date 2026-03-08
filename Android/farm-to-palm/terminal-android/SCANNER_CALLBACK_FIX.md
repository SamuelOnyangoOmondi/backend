# Scanner not working / not blinking — quick fix

If the palm scanner does not activate (no blink, no scan) even though the vendor SDK is installed, the open callback is likely wrong.

## Rule

**Pass a real `IOpenCallback` implementation to the SDK. Do not pass a dynamic Proxy.**

## What to do

### 1. VeinshineOpenCallback.kt

- Implement the vendor interface: `class VeinshineOpenCallback(...) : IOpenCallback`
- Use: `import com.api.stream.IOpenCallback`
- Do not implement a stub interface or wrap in a Proxy.

### 2. VeinshinePalmSdk.kt (in `createAndOpenDevice`)

- Get the method:  
  `val openMethod = device.javaClass.getMethod("open", com.api.stream.IOpenCallback::class.java)`
- Invoke with the real callback:  
  `openMethod.invoke(device, openCallback)`
- Do not create a `Proxy.newProxyInstance(...)` and do not pass that proxy to `invoke(device, ...)`.

### 3. Compile with the JAR

The vendor JAR must be in `app/libs/` at compile time (run `./scripts/install_vendor_sdk.sh` with your SDK path). Otherwise the project will not compile when using the real `IOpenCallback`.

---

**Why:** The native code in `libstream_jni.so` expects a normal Java object that implements `com.api.stream.IOpenCallback`. A Proxy can cause the device open to fail or the scanner to never activate. Using the real implementation restores correct behavior.

**Related:** JNI crash `CallVoidMethodV does not match void ... onDownloadPrepare()` can also appear when using a Proxy with mismatched return types; the stable fix is to use the real callback as above. See `INSTALL_VENDOR_SDK.md` → Troubleshooting for more detail.
