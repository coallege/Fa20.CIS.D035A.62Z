# 6.22 - Babylonian Method

Requires at least JDK 10.

First I prototyped it in JavaScript recursively.
As far as I know, neither languages perform tail call optimization so I used a
trampoline instead. The special terminal output will only work on terminals that
support vt100 codes. `conhost.exe` doesn't do this, annoyingly.
