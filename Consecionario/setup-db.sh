#!/bin/bash

echo "Restaurando la base de datos desde backup.sql..."
mysql -u root -p < backup.sql
echo "Base de datos restaurada con éxito."
