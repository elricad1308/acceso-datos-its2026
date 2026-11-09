import 'package:flutter/material.dart';

class ContactoTile extends StatelessWidget {
  const ContactoTile({super.key, required this.nombre, required this.correo});

  final String nombre;
  final String correo;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8),
      child: Row(
        children: [
          CircleAvatar(child: Text(nombre[0])),
          const SizedBox(width: 12),
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(nombre, style: const TextStyle(fontWeight: FontWeight.bold)),
              Text(correo),
            ],
          ),
        ],
      ),
    ); // Fi
  }
}
