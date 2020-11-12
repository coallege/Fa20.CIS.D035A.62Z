# Fa20.CIS.D035A.62Z

*IntoToJava.class*

![](resources/scrange.png)

# Learnings

I already took an intro to Java class at d.tech before where I learned and
taught myself most of Java. However, looks like I didn't learn *everything* that
there was to learn about the language. Heck, I still don't understand the point
of `? extends` and `? super` or even the `?` in the first place. I've read a
little about it on stackoverflow but never quite got it. And I'm rambling again.
Basically, I'm going to record the things that I've learned in this class. Most,
if not all of the things listed below weren't taught in the class.

```java
// turbofish in Java
Instance.<Type>Method();

// Type aliasing in Java (discovered by yours truly)
class Clazz<T extends SuperLongTypeThatIUseABunch> {
	void accept(T t);

	// And in methods
	<U extends OtherLongTypeOhMyGod> void calc() {
		U val;
		U res;
	}
}

// Annotations
@interface Annotations {};

// Defender Methods
interface Defended {
	default void defended() {};
}

// Cursed c-like array declarations
int ary[];

int ary()[] {};

// while talking with Joshua
// https://stackoverflow.com/questions/44310226
// https://discord.com/channels/206602548210040832/482633314155626497/772713396415496192

stream.toArray(String[]::new);
// is the same thing as
stream.toArray(size -> new String[size]);
// looks like it has a constructor of it's own or something

String multiline = (
	"""
	Yes!
	Finally multiline Strings in Java!
	"""
);

// String::indent mentioned in the JEP for multiline strings
// added in Java 11 and I just missed it or something

var multiline_indented = multiline.indent(3);

// Java 14 has switch expressions yes yees ye s!

final int a = 1;
String life_feeling = switch(a) {
	case 1 -> "pain";
	default -> {
		yield "also pain";
	}
}
```

### Classpaths

Re-learned classpath for like the 34509834509384509485th time.
Actually, this is probably the third time.


### vscode-java and Eclipse Java LSP

#### Project Identification

The Java LSP identifies projects if there is a `.project` file in the directory.
Here's a good example one:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
	<name>assignment336b</name>
	<!-- <buildSpec>
		<buildCommand>
			<name>org.eclipse.jdt.core.javabuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
	</buildSpec> -->
	<natures>
		<nature>org.eclipse.jdt.core.javanature</nature>
	</natures>
</projectDescription>
```

The `natures` field is the most important part.


Including the `.project` file, there also should be a `.classpath` file.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="src" output="bin" path="my/source/directory"/>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER"/>
</classpath>
```

For the `classpathentries`, see:

[eclipse.jdt.internal.core.ClasspathEntry](https://github.com/eclipse/eclipse.jdt.core/blob/553e15826cc46c11229f17fd6da0fa43ed0055a9/org.eclipse.jdt.core/model/org/eclipse/jdt/internal/core/ClasspathEntry.java#L1501-L1518
)

### JUnit4

It's a pain to set up manually but it works, I suppose.

I didn't *really* learn it but I learned how to set it up which for me, is like
half of the learning. Getting JUnit4 set up meant that I had to read about the
`ClassPathEntry`s and about annotations. Even though I didn't learn a whole lot
about the library itself, it was totally worth trying it out just because of the
cascading learning effect.

#### Invisible/Implicit Projects

So there exist "invisible" projects which are stored in the Java language server
workspace. They can hold shadow files like the `.project` and `.classpath`.

### Gradle

Learned about the basics of how Gradle works and even set up a small project.

### Kotlin

```kotlin
// companion objects and static methods
class Static {
	companion object {
		fun method(): Unit {
			println("I'm \"static\"!")
		}
	}
}
```

And also that I don't wanna use it without a proper IDE.
