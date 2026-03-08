# Run Supa School & Dashboard

## 1. Supa School (web app)

From the **repo root**:

```bash
cd supaschool
npm install
npm run dev
```

Then open in your browser: **http://localhost:5173** (Vite default).

Using Bun:

```bash
cd supaschool
bun install
bun run dev
```

---

## 2. Farm-to-Palm dashboard (Next.js)

From the **repo root**:

```bash
cd Android/farm-to-palm/dashboard
npm install
npm run dev
```

Then open: **http://localhost:3001**

---

## 3. Run both (two terminals)

**Terminal 1 – Supa School:**
```bash
cd supaschool && npm install && npm run dev
```

**Terminal 2 – Dashboard:**
```bash
cd Android/farm-to-palm/dashboard && npm install && npm run dev
```

- Supa School: http://localhost:5173  
- Dashboard: http://localhost:3001  

---

## Optional: Supa School preview (production build)

```bash
cd supaschool
npm run build
npm run preview
```

Preview URL is usually http://localhost:4173 (see terminal output).

---

## 4. Connect the Android device and test

The **terminal device** (phone/tablet with the Farm-to-Palm app) talks to the **backend**. You can connect and test once the backend is running and the device is on the same Wi‑Fi.

### Step 1: Start the backend

From the **repo root** (in a new terminal):

```bash
cd Android/farm-to-palm/backend
npm install
npm run dev
```

Backend runs on **port 3000** (e.g. `http://localhost:3000`). It binds to `0.0.0.0`, so it’s reachable on your machine’s **LAN IP** (e.g. `http://192.168.1.128:3000`).

### Step 2: Get your computer’s IP (for the device)

On the machine running the backend:

- **macOS/Linux:** `ifconfig | grep "inet "` or `ip addr` and use the `192.168.x.x` (or `10.x.x.x`) address.
- **Windows:** `ipconfig` and use the IPv4 address of your Wi‑Fi adapter.

Example: `192.168.1.128` → backend URL is **`http://192.168.1.128:3000`**.

### Step 3: Install and open the app on the device

1. Build and install the Android app from **Android Studio** (open `Android/farm-to-palm/terminal-android` or `Android/` and run on a connected device or emulator).
2. Put the **device on the same Wi‑Fi** as the computer running the backend.
3. Open the app. You should see the **Activation** screen.

### Step 4: Activate the terminal

1. In the app, set **Base URL** to your backend, e.g. `http://192.168.1.128:3000` (use your actual IP from Step 2).
2. Tap **Test** to confirm the backend is reachable (optional).
3. Enter your **activation code** (from your backend/school setup) and complete activation.
4. After activation you’ll get to **Home** (Attendance, Meal, etc.).

### Step 5: Test attendance / meals

- **Attendance:** Tap **Scan Attendance** → scan palm → event is stored on device and can sync to backend.
- **Meal:** Tap **Record Meal** → scan palm or use NFC → event is stored and can sync.

Sync (and any reports) use the same backend URL saved at activation. You can view data in the **dashboard** at http://localhost:3001 (with the dashboard running as in section 2).

### Device not near the Mac? Use a public URL

If the device is on a different network (e.g. at school while the backend runs on your Mac at home), **localhost / LAN IP will not work**. Use a **public URL** instead:

- **Quick (testing):** Expose your local backend with a tunnel (e.g. [ngrok](https://ngrok.com) or Cloudflare Tunnel). Put the tunnel URL in the app under **Settings → API base URL**.
- **Always on:** Deploy the backend to Railway, Render, Fly.io, or a VPS and use that URL on the device.

See **[Android/farm-to-palm/backend/PUBLIC_URL.md](Android/farm-to-palm/backend/PUBLIC_URL.md)** for step-by-step options.

### Checklist

- [ ] Backend running: `cd Android/farm-to-palm/backend && npm run dev`
- [ ] Device on same Wi‑Fi as the computer **or** backend reachable via a public URL (see PUBLIC_URL.md)
- [ ] App installed and opened; Activation screen shows
- [ ] Base URL = `http://<your-computer-IP>:3000` (same network) or a public HTTPS URL (anywhere)
- [ ] Activation completed; Home screen visible
- [ ] Test a scan (attendance or meal) and optionally check dashboard/backend
