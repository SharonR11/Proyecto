# Generated by Django 4.2.2 on 2023-07-07 03:36

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('trabajo', '0006_alter_empresa_ruc'),
    ]

    operations = [
        migrations.AlterField(
            model_name='empleado',
            name='dni',
            field=models.BigIntegerField(),
        ),
        migrations.AlterField(
            model_name='empresa',
            name='telefono',
            field=models.BigIntegerField(),
        ),
        migrations.AlterField(
            model_name='estudiante',
            name='dni',
            field=models.BigIntegerField(),
        ),
        migrations.AlterField(
            model_name='estudiante',
            name='telefono',
            field=models.BigIntegerField(),
        ),
    ]
