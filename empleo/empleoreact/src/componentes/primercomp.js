import React from 'react'

const Primercomponente = () => {

    let nombre="Rudas";
    let email="srudas@gmail.com";
    let curso=[
        "Python",
        "Java",
        "Php",
        "Oracle"
    ];

    return (
        <div>
            <h1>Mi primer comopnente</h1>
            <p>Este es el primer comopnente</p>
            <p>Mi nombre es: {nombre}</p>
            <p>Mi correo es: {email}</p>
            <h2>Lista de cursos</h2>
            <ul>
                {curso.map((curso,indicie)=>{
                return (<li>
                    {curso}
                </li>)
                })
                }
            </ul>
        </div>
    )
}
export default Primercomponente