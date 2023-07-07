from django.db import models
from django.core.validators import MaxValueValidator,MinValueValidator
# Create your models here.
class CargoTrabajo(models.Model):
    idCargo = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=150)
    def __str__(self):
        return self.nombre
#-------Industrias------------
class Sector(models.Model):
    idSector = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=100)
    def __str__(self):
        return self.nombre

#-------Usuarios(admin,estudiante,empresa,empleado)
class TipoUsuario(models.Model):
    idTipo = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=20)
    def __str__(self):
        return self.nombre

class Empresa(models.Model):
    idEmpresa = models.AutoField(primary_key=True)
    tipousuario = models.ForeignKey(TipoUsuario,on_delete=models.CASCADE)
    nombre = models.CharField(max_length=50)
    apellido = models.CharField(max_length=50)
    correo = models.CharField(max_length=255)
    contraseña = models.CharField(max_length=50)
    empresa = models.CharField(max_length=70)
    razonsocial = models.CharField(max_length=100)
    ruc = models.BigIntegerField()
    direccion = models.CharField(max_length=255)
    telefono = models.BigIntegerField()
    sector = models.ForeignKey(Sector,on_delete=models.CASCADE)
    def __str__(self):
        return self.razonsocial

class Empleado(models.Model):
    idEmpleado = models.AutoField(primary_key=True)
    empresa = models.ForeignKey(Empresa,on_delete=models.CASCADE)
    nombre = models.CharField(max_length=255)
    apellido = models.CharField(max_length=255)
    correo = models.CharField(max_length=255)
    contraseña = models.CharField(max_length=30)
    dni = models.BigIntegerField()
    direccion = models.CharField(max_length=255)
    def __str__(self):
        return self.nombre
    
class Estudiante(models.Model):
    idEstudiante = models.AutoField(primary_key=True)
    tipousuario = models.ForeignKey(TipoUsuario,on_delete=models.CASCADE)
    nombre = models.CharField(max_length=255)
    apellido = models.CharField(max_length=255)
    dni = models.BigIntegerField()
    telefono = models.BigIntegerField()
    correo = models.CharField(max_length=255)
    contraseña = models.CharField(max_length=30)
    def __str__(self):
        return self.nombre

#-----------Oferta de Trabajo-------------
class OfertaTrabajo(models.Model):
    idOferta = models.AutoField(primary_key=True)
    empresa = models.ForeignKey(Empresa,on_delete=models.CASCADE)
    nombre = models.CharField(max_length=255)
    descripcion = models.TextField()
    sueldo = models.DecimalField(max_digits=10, decimal_places=2)
    cargo = models.ForeignKey(CargoTrabajo,on_delete=models.CASCADE)
    fecha = models.DateField()
    def __str__(self):
        return self.nombre

class Postulacion(models.Model):
    idPostulacion = models.AutoField(primary_key=True)
    estudiante = models.ForeignKey(Estudiante,on_delete=models.CASCADE)
    oferta = models.ForeignKey(OfertaTrabajo,on_delete=models.CASCADE)
    fecha = models.DateField()
    cv = models.FileField(upload_to = "Uploaded Files/")
    def __str__(self):
        return f"{self.estudiante.nombre} {self.oferta.nombre}"