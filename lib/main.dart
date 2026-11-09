import 'package:flutter/material.dart';

import 'contacto_tile.dart';

import 'contacto_model.dart';

const contactos = [
  Contacto('Justino Ortegón', 'jramireo@uacam.mx'),
  Contacto('Heribe Uribe', 'hefuribe@uacam.mx'),
  Contacto('Joel Flores', 'jcflores@uacam.mx'),
  Contacto('Jose Aguilar', 'jcaguilc@uacam.mx'),
  Contacto('Gabriel Canto', 'gcanto@uacam.mx'),
];

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
      body: ListView.builder(
        itemCount: contactos.length,
        itemBuilder: (context, index) =>
            ContactoTile(contacto: contactos[index]),
      ),
    );
  }
}
