package com.esaudiaz.larashopmovil.features.employee.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esaudiaz.larashopmovil.features.employee.domain.entities.Empleado

// Colores LaraShop
private val LaraShopPink = Color(0xFFE91E8C)
private val LaraShopPinkLight = Color(0xFFF8E1EF)
private val IconGray = Color(0xFFE0E0E0)

@Composable
fun EmpleadoCard(
    empleado: Empleado,
    onToggleEstado: (Int, String) -> Unit,
    onEdit: (Empleado) -> Unit,
    onDelete: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icono de usuario
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(LaraShopPink, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Información del empleado
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = empleado.nombre,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = empleado.correo,
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Botón de estado (Activo/Inactivo)
            Button(
                onClick = { onToggleEstado(empleado.id, empleado.estado) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = LaraShopPink,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                modifier = Modifier.height(32.dp)
            ) {
                Text(
                    text = if (empleado.estado == "activo") "Activo" else "Inactivo",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Botón de editar
            IconButton(
                onClick = { onEdit(empleado) },
                modifier = Modifier
                    .size(40.dp)
                    .background(IconGray, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Editar",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Botón de eliminar
            IconButton(
                onClick = { onDelete(empleado.id) },
                modifier = Modifier
                    .size(40.dp)
                    .background(IconGray, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}