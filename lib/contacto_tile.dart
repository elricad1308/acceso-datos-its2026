import 'package:flutter/material.dart';

import 'contacto_model.dart';

class ContactoTile extends StatefulWidget {
  // Constructor
  const ContactoTile({super.key, required this.contacto});

  final Contacto contacto;

  // Cada vez que el estado cambia
  // Flutter crea un nuevo widget
  @override
  State<ContactoTile> createState() => _ContactoTileState();
}

class _ContactoTileState extends State<ContactoTile> {
  bool _favorito = false;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8),
      child: Row(
        children: [
          CircleAvatar(child: Text(widget.contacto.nombre[0])),
          const SizedBox(width: 12),
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                widget.contacto.nombre,
                style: const TextStyle(fontWeight: FontWeight.bold),
              ),
              Text(widget.contacto.correo),
            ],
          ),
          IconButton(
            icon: Icon(_favorito ? Icons.favorite : Icons.heart_broken),
            color: _favorito ? Colors.pink : Colors.green,
            onPressed: () {
              setState(() {
                _favorito = !_favorito;
              });
              print(_favorito);
            },
          ),
        ],
      ),
    ); // Fi
  }
}
