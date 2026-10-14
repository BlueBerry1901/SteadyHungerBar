# StableHunger

A tiny client-side Fabric mod for Minecraft 1.21.10 that removes the hunger
bar's positional jitter — the pixel-shake that happens to individual hunger
icons once saturation hits 0 — without changing any hunger, saturation,
exhaustion, or food mechanic.

## What it changes

- **Positional jitter: removed.** Vanilla randomly nudges each hunger icon
  by -1/0/+1 pixels vertically once saturation is fully depleted.
  StableHunger neutralizes that offset so the icons stay in their normal
  position.

## What it does NOT change

- Hunger depletion, saturation, exhaustion rates — untouched.
- Food consumption / restoration — untouched.
- The `Hunger` status effect's icon *texture* swap — untouched. That's a
  different, intentional visual signal (not jitter), so it still works.
- Health hearts and their own critical-health jitter — untouched.
- Air bubbles and their low-oxygen jitter — untouched.
- Armor bar, XP bar, and every other HUD element — untouched.
- No config screen, no keybinds, no networking, no telemetry.

## How it works

Vanilla's `Gui#renderFood` applies `this.random.nextInt(3) - 1` to each
icon's vertical position whenever saturation is 0 on a qualifying game
tick. StableHunger uses a single Mixin (`@ModifyExpressionValue`) scoped to
that one method, forcing the random draw's result so the net offset is
always zero — while still consuming the draw from the shared
`RandomSource`, so the fix has no effect on the independent jitter used by
low-health hearts or low-air bubbles elsewhere in the same class.

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 1.21.10.
2. Drop the StableHunger jar into your `.minecraft/mods` folder.
3. Launch the game — no Fabric API or other mod dependency required.

## Supported versions

- **Minecraft:** 1.21.10 only, pinned exactly. The mod refuses to load on
  other versions rather than silently doing nothing if the target method
  has changed.
- **Loader:** Fabric Loader 0.19.5+
- **Environment:** Client-side only. Works against a vanilla, unmodified
  server — do not install it on the server.

## Known limitations

- Pinned to exactly 1.21.10; a future Minecraft version may require a new
  release if `Gui#renderFood` changes.
- Not tested against other mods that also modify hunger-bar rendering —
  such a mod could conflict with this one's Mixin.
- Verified in a Fabric development singleplayer world; not yet verified
  against a real dedicated server or in a live multiplayer session.

## Reporting bugs

TBD — will be added once the project has a public issue tracker.

## License

MIT — see [LICENSE](LICENSE).
