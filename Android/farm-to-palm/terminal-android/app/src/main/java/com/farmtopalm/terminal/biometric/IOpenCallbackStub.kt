package com.farmtopalm.terminal.biometric

/**
 * Local stub of the vendor's com.api.stream.IOpenCallback so we compile without the SDK JAR.
 * At runtime, VeinshinePalmSdk wraps the implementation in a proxy that implements the real
 * com.api.stream.IOpenCallback when the JAR is present.
 */
interface IOpenCallbackStub {
    fun onDownloadPrepare()
    fun onDownloadProgress(progress: Int)
    fun onDownloadSuccess()
    fun onOpenSuccess()
    fun onOpenFail(code: Int)
}
