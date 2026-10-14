# Changelog

## 1.0.0 - 2026-10-14

Initial release.

- Removes the hunger bar's saturation-zero positional jitter via a single
  Mixin into `Gui#renderFood`.
- No changes to hunger, saturation, exhaustion, or any other gameplay
  mechanic — the fix only affects how hunger icons are drawn.
- Verified in a Fabric 1.21.10 development environment:
  - Jitter is gone once saturation reaches 0 while sprinting.
  - The `Hunger` status effect's icon texture swap still works.
  - Hunger values still update correctly on eating/starving.
  - Heart-row jitter at critical health still works, unaffected.
  - Air-bubble jitter at low oxygen still works, unaffected.
  - Armor bar and other HUD elements unaffected.
