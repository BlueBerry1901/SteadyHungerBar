**Steady Hunger Bar** stops the hunger bar from visually jittering.

In vanilla Minecraft, once your saturation hits exactly 0, each hunger
icon starts getting randomly nudged up or down by a pixel, independently
of the others. This mod removes that pixel-shake. The hunger icons stay
in their normal position no matter what your saturation or hunger level
is.

### Background

This mod was made out of curiosity following the Dream speedrun
controversy, where the hunger bar's pixel-shake was widely discussed as
one of the signals used to scrutinize footage. Looking into *why* the
bar jitters at all led to this: a small, targeted fix for the visual
effect itself, with zero changes to actual hunger/saturation gameplay.

### Why you'd want this

If you've ever noticed the hunger bar "vibrating" while sprinting or
after your saturation runs out — and found it visually distracting, hard
to screenshot/record cleanly, or just annoying — this fixes exactly that,
and only that.

### What this mod does NOT do

This is a purely visual fix. It does not touch hunger mechanics in any
way:

- Hunger depletion, saturation, and exhaustion all work exactly like
  vanilla.
- Food consumption and hunger restoration are untouched.
- The `Hunger` status effect still changes the icons' appearance (that's
  a different, intentional effect — not jitter — and is left alone).
- Health hearts and their own low-health jitter, air bubbles and their
  low-oxygen jitter, the armor bar, and the XP bar are all untouched.
- No config screen, no keybinds, no networking, no telemetry, no other
  features.

### Before you download

- **Minecraft 1.21.10 only**, pinned exactly. The mod will refuse to load
  on a different Minecraft version rather than silently failing to work.
- **Client-side only.** Install it on your client; a vanilla, unmodified
  server works fine, and you do not need to (and should not) install this
  on the server.
- No dependency on Fabric API or any other mod.

Source code, technical write-up of exactly how the fix works, and the
issue tracker: https://github.com/BlueBerry1901/SteadyHungerBar
