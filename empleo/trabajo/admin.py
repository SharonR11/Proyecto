from django.contrib import admin
from .models import CargoTrabajo,Sector,TipoUsuario,Empresa
from .models import Empleado,Estudiante,OfertaTrabajo,Postulacion
# Register your models here.
admin.site.register(CargoTrabajo)
admin.site.register(Sector)
admin.site.register(TipoUsuario)
admin.site.register(Empresa)
admin.site.register(Empleado)
admin.site.register(Estudiante)
admin.site.register(OfertaTrabajo)
admin.site.register(Postulacion)