[README (2).md](https://github.com/user-attachments/files/24357939/README.2.md)
# Perfiles Acero - Aplicación Android

Una aplicación móvil Android desarrollada en Kotlin con Jetpack Compose para la gestión y visualización de productos de acero y perfiles metálicos.

## 📱 Características Principales

- **Catálogo de Productos**: Visualización de productos de acero incluyendo placas, láminas, ángulos, canales y cemento
- **Carrito de Compras**: Funcionalidad completa para agregar y gestionar productos
- **Autenticación**: Sistema de login y registro de usuarios
- **Tipo de Cambio**: Integración con API de Banxico para consultar tipos de cambio en tiempo real
- **Base de Datos Local**: Almacenamiento persistente con Room Database
- **Notificaciones**: Sistema de notificaciones para actualizaciones de productos

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **UI Framework**: Jetpack Compose
- **Arquitectura**: MVVM (Model-View-ViewModel)
- **Base de Datos**: Room Database
- **Navegación**: Navigation Compose
- **API REST**: Retrofit + Gson
- **Gestión de Estado**: ViewModel + LiveData
- **Notificaciones**: Android Notification Manager

## 📦 Productos Disponibles

1. **PLACA EN HOJA Y ROLLO** - Placas de acero en diferentes presentaciones
2. **LÁMINA ROLADA EN CALIENTE** - Láminas de acero procesadas en caliente
3. **ÁNGULO** - Perfiles angulares de acero
4. **CANAL C.P.S.** - Canales de acero con perfil específico
5. **CEMENTO HOLCIM** - Cemento de construcción marca Holcim

## 🏗️ Arquitectura del Proyecto

```
app/src/main/java/com/example/perfilesacero/
├── data/
│   ├── network/           # Servicios API (Banxico)
│   ├── AppDatabase.kt     # Configuración Room Database
│   ├── ProductDao.kt      # Data Access Object
│   ├── ProductEntity.kt   # Entidades de base de datos
│   └── DataSource.kt      # Fuente de datos estática
├── ui/
│   ├── screens/           # Pantallas de la aplicación
│   ├── theme/            # Tema y estilos
│   └── viewmodels/       # ViewModels para gestión de estado
└── MainActivity.kt       # Actividad principal
```

## 🚀 Instalación y Configuración

### Prerrequisitos
- Android Studio Arctic Fox o superior
- SDK de Android 24 (API level 24) o superior
- Kotlin 1.8+

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/Pame1213/Perfilesacero.git
   cd Perfilesacero
   ```

2. **Abrir en Android Studio**
   - Abrir Android Studio
   - Seleccionar "Open an existing project"
   - Navegar hasta la carpeta del proyecto

3. **Sincronizar dependencias**
   - Android Studio sincronizará automáticamente las dependencias de Gradle
   - Esperar a que termine la sincronización

4. **Ejecutar la aplicación**
   - Conectar un dispositivo Android o iniciar un emulador
   - Hacer clic en "Run" o presionar Shift + F10

## 🔧 Configuración de API

La aplicación utiliza la API de Banxico para obtener tipos de cambio. El token está configurado en `build.gradle.kts`:

```kotlin
buildConfigField("String", "BANXICO_TOKEN", "\"c6bb47c0b8b62475e8849a171fc41d6b92911c3d66c1686a6c094ab6a4f23648\"")
```

## 🎨 Desarrollo de UI

### Diseño y Componentes
La interfaz está desarrollada completamente con **Jetpack Compose**, utilizando Material Design 3:

- **Cards**: Componentes Card con elevación y bordes redondeados para productos
- **LazyVerticalGrid**: Grid responsivo de 2 columnas para el catálogo
- **TopAppBar**: Barra superior con navegación y acciones
- **Scaffold**: Estructura base para todas las pantallas
- **Navigation**: Sistema de navegación declarativo entre pantallas

### Tema y Colores
- **Color Principal**: `Color(0xFFBCAAA4)` - Tono tierra/beige
- **Formas**: Bordes redondeados de 12dp y 16dp
- **Tipografía**: Material Design con pesos Bold para títulos
- **Imágenes**: ContentScale.Crop para optimización visual

### Componentes Reutilizables
- **ProductCard**: Tarjeta de producto con imagen y overlay de texto
- **Botones**: Estilo consistente con forma redondeada
- **Iconos**: Material Icons para navegación y acciones

## 📱 Pantallas de la Aplicación

1. **LoginScreen**: Pantalla de autenticación de usuarios
2. **UserProfileScreen**: Perfil del usuario con opción de consultar tipo de cambio
3. **ProductScreen**: Catálogo principal de productos
4. **ProductDetailScreen**: Detalles específicos de cada producto
5. **CartScreen**: Carrito de compras con productos seleccionados

## 🗄️ Base de Datos

La aplicación utiliza Room Database para almacenamiento local:

- **ProductEntity**: Entidad para productos con ID, nombre y descripción
- **ProductDao**: Interface para operaciones CRUD
- **AppDatabase**: Configuración principal de la base de datos

## 🌐 Integración de API

### Banxico API
- **Endpoint**: Series de tipos de cambio
- **Autenticación**: Token Bearer
- **Funcionalidad**: Consulta de tipo de cambio USD/MXN en tiempo real

## 📋 Dependencias Principales

```kotlin
// Jetpack Compose
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.activity:activity-compose")

// Navigation
implementation("androidx.navigation:navigation-compose")

// Room Database
implementation("androidx.room:room-runtime")
implementation("androidx.room:room-ktx")

// Retrofit para API
implementation("com.squareup.retrofit2:retrofit")
implementation("com.squareup.retrofit2:converter-gson")

// ViewModel
implementation("androidx.lifecycle:lifecycle-viewmodel-compose")
```

## 🔒 Permisos

La aplicación requiere los siguientes permisos:
- `INTERNET`: Para conexión a APIs externas
- `POST_NOTIFICATIONS`: Para mostrar notificaciones

## 👥 Contribución

1. Fork el proyecto
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 📞 Contacto

Para preguntas o sugerencias sobre el proyecto, puedes contactar a través del repositorio de GitHub.

---

**Versión**: 1.0  
**Última actualización**: 2024  
**Desarrollado con**: ❤️ y Kotlin
