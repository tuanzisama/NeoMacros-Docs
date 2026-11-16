把精确签名（含私有成员）解析为 `ReflectClass` / `ReflectField` / `ReflectMethod` / `ReflectConstructor` 句柄，覆盖 Class 枚举、字段读写、方法调用、构造器、修饰符与注解查询——整个模块走 java 权限门禁。

```js
const { reflect } = neo;

// Class.forName 入口：教程 Class 类的枚举面
const cls = reflect.forName('java.util.ArrayList');
cls.fields();                              // 公共字段（含继承）
cls.declaredFields();                      // 类自身声明（含私有）
cls.superclass().className;                // 'java.util.AbstractList'
cls.interfaces();                          // 接口句柄数组

// 构造器句柄（教程 Constructor 类）；setAccessible 已自动开启
const list = cls.constructor().newInstance([]);

// 字段句柄（教程 Field 类）：私有字段照常读写
const size = cls.field('size');
size.name;                                 // 'size'
size.private;                              // true —— isX() 读为属性
size.get(list);                            // 读取实例字段
size.type().className;                     // 'int'

// 方法句柄（教程 Method 类）：反射调用，数字参数按声明类型转换
const add = cls.method('add', ['java.lang.Object']);
add.returnType().className;                // 'boolean'
add.invoke(list, ['torch']);               // 实例调用；静态方法 target 传 null

// 修饰符与注解
add.public;                                // isPublic() → 属性
add.modifiers();                           // 原始位掩码
cls.isAnnotationPresent('java.lang.Deprecated'); // 仅 RUNTIME 保留可见

// 模块函数仍然可用：按名解析 + 兼容调用
const resolved = reflect.method(list, 'add', ['java.lang.Object']);
reflect.invoke(resolved, list, ['copper']);
reflect.className(list);                   // 'java.util.ArrayList'
```
