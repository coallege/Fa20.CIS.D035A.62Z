# Fa20.CIS.D035A.62Z

*IntoToJava.class*

![](resources/scrange.png)

# Learnings

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

https://github.com/eclipse/eclipse.jdt.core/blob/553e15826cc46c11229f17fd6da0fa43ed0055a9/org.eclipse.jdt.core/model/org/eclipse/jdt/internal/core/ClasspathEntry.java#L1501-L1518

#### Invisible/Implicit Projects

So there exist "invisible" projects which are stored in the Java language server
workspace. They can hold shadow files like the `.project` and `.classpath`.

### Gradle

Learned about the basics of how Gradle works and even set up a small project.


### JUnit

It's a pain to set up manually but it works, I suppose.
