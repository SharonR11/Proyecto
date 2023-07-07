# Generated by Django 4.2.2 on 2023-07-07 02:44

import django.core.validators
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='CargoTrabajo',
            fields=[
                ('idCargo', models.AutoField(primary_key=True, serialize=False)),
                ('nombre', models.CharField(max_length=150)),
            ],
        ),
        migrations.CreateModel(
            name='Empresa',
            fields=[
                ('idEmpresa', models.AutoField(primary_key=True, serialize=False)),
                ('nombre', models.CharField(max_length=50)),
                ('apellido', models.CharField(max_length=50)),
                ('correo', models.CharField(max_length=255)),
                ('contraseña', models.CharField(max_length=50)),
                ('empresa', models.CharField(max_length=70)),
                ('razonsocial', models.CharField(max_length=100)),
                ('ruc', models.IntegerField(validators=[django.core.validators.MaxValueValidator(13), django.core.validators.MinValueValidator(1)])),
                ('direccion', models.CharField(max_length=255)),
                ('telefono', models.IntegerField(validators=[django.core.validators.MaxValueValidator(9), django.core.validators.MinValueValidator(1)])),
            ],
        ),
        migrations.CreateModel(
            name='Estudiante',
            fields=[
                ('idEstudiante', models.AutoField(primary_key=True, serialize=False)),
                ('nombre', models.CharField(max_length=255)),
                ('apellido', models.CharField(max_length=255)),
                ('dni', models.IntegerField(validators=[django.core.validators.MaxValueValidator(8), django.core.validators.MinValueValidator(1)])),
                ('telefono', models.IntegerField(validators=[django.core.validators.MaxValueValidator(9), django.core.validators.MinValueValidator(1)])),
                ('correo', models.CharField(max_length=255)),
                ('contraseña', models.CharField(max_length=30)),
            ],
        ),
        migrations.CreateModel(
            name='OfertaTrabajo',
            fields=[
                ('idOferta', models.AutoField(primary_key=True, serialize=False)),
                ('nombre', models.CharField(max_length=255)),
                ('descripcion', models.TextField()),
                ('sueldo', models.DecimalField(decimal_places=2, max_digits=10)),
                ('fecha', models.DateField()),
                ('cargo', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='trabajo.cargotrabajo')),
                ('empresa', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='trabajo.empresa')),
            ],
        ),
        migrations.CreateModel(
            name='Sector',
            fields=[
                ('idSector', models.AutoField(primary_key=True, serialize=False)),
                ('nombre', models.CharField(max_length=100)),
            ],
        ),
        migrations.CreateModel(
            name='TipoUsuario',
            fields=[
                ('idTipo', models.AutoField(primary_key=True, serialize=False)),
                ('nombre', models.CharField(max_length=20)),
            ],
        ),
        migrations.CreateModel(
            name='Postulacion',
            fields=[
                ('idPostulacion', models.AutoField(primary_key=True, serialize=False)),
                ('fecha', models.DateField()),
                ('cv', models.FileField(upload_to='Uploaded Files/')),
                ('estudiante', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='trabajo.estudiante')),
                ('oferta', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='trabajo.ofertatrabajo')),
            ],
        ),
        migrations.AddField(
            model_name='estudiante',
            name='tipousuario',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='trabajo.tipousuario'),
        ),
        migrations.AddField(
            model_name='empresa',
            name='sector',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='trabajo.sector'),
        ),
        migrations.AddField(
            model_name='empresa',
            name='tipousuario',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='trabajo.tipousuario'),
        ),
        migrations.CreateModel(
            name='Empleado',
            fields=[
                ('idEmpleado', models.AutoField(primary_key=True, serialize=False)),
                ('nombre', models.CharField(max_length=255)),
                ('apellido', models.CharField(max_length=255)),
                ('correo', models.CharField(max_length=255)),
                ('contraseña', models.CharField(max_length=30)),
                ('dni', models.IntegerField(validators=[django.core.validators.MaxValueValidator(8), django.core.validators.MinValueValidator(1)])),
                ('direccion', models.CharField(max_length=255)),
                ('empresa', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='trabajo.empresa')),
            ],
        ),
    ]
