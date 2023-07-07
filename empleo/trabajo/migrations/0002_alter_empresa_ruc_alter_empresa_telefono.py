# Generated by Django 4.2.2 on 2023-07-07 03:21

import django.core.validators
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('trabajo', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='empresa',
            name='ruc',
            field=models.IntegerField(validators=[django.core.validators.MaxValueValidator(9999999999999), django.core.validators.MinValueValidator(0)]),
        ),
        migrations.AlterField(
            model_name='empresa',
            name='telefono',
            field=models.IntegerField(validators=[django.core.validators.MaxValueValidator(10), django.core.validators.MinValueValidator(1)]),
        ),
    ]
