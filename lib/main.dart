import 'package:flutter/material.dart';

import 'contacto_tile.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Contactos',
      theme: ThemeData(colorSchemeSeed: Colors.blueGrey, useMaterial3: true),
      home: const PantallaContactos(),
    );
  }
}

class PantallaContactos extends StatelessWidget {
  const PantallaContactos({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: const Column(
        children: [
          ContactoTile(nombre: 'Justino Ramirez', correo: 'jramireo@uacam.mx'),
          ContactoTile(nombre: 'Heribe Uribe', correo: 'hefuribe@uacam.mx'),
          ContactoTile(nombre: 'Joel Flores', correo: 'jcflores@uacam.mx'),
          ContactoTile(nombre: 'Jose Aguilar', correo: 'jcaguilc@uacam.mx'),
          ContactoTile(nombre: 'Gabriel Canto', correo: 'gcanto@uacam.mx'),
        ],
      ),
    );
  }
}
