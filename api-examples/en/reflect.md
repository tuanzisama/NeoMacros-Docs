Resolve exact signatures (private members included) into `ReflectClass` / `ReflectField` / `ReflectMethod` / `ReflectConstructor` handles covering the Class enumeration, field reads and writes, method invocation, constructors, modifiers and annotation queries — the whole module rides the java permission gate.

```js
const { reflect } = neo;

// Class.forName entry point: the tutorial's Class enumeration surface
const cls = reflect.forName('java.util.ArrayList');
cls.fields();                              // public fields, inherited included
cls.declaredFields();                      // declared on the class, private included
cls.superclass().className;                // 'java.util.AbstractList'
cls.interfaces();                          // interface handle array

// Constructor handle (the tutorial's Constructor class); setAccessible is automatic
const list = cls.constructor().newInstance([]);

// Field handle (the tutorial's Field class): private fields read and write like public
const size = cls.field('size');
size.name;                                 // 'size'
size.private;                              // true — isX() reads as a property
size.get(list);                            // read an instance field
size.type().className;                     // 'int'

// Method handle (the tutorial's Method class): invoke reflectively, numbers convert
const add = cls.method('add', ['java.lang.Object']);
add.returnType().className;                // 'boolean'
add.invoke(list, ['torch']);               // instance call; pass null for statics

// Modifiers and annotations
add.public;                                // isPublic() → property
add.modifiers();                           // the raw modifier mask
cls.isAnnotationPresent('java.lang.Deprecated'); // runtime-retained only

// Module functions stay available: resolve by name + compatible invocation
const resolved = reflect.method(list, 'add', ['java.lang.Object']);
reflect.invoke(resolved, list, ['copper']);
reflect.className(list);                   // 'java.util.ArrayList'
```
