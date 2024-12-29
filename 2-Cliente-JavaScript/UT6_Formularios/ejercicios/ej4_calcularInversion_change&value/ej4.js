document.addEventListener("DOMContentLoaded", () => {
  /*
  Crea una interfaz que permita ingresar una suma de depósito bancario y porcentaje, luego calcula cuánto será después de un periodo de tiempo determinado.
  Cualquier modificación debe ser procesada de inmediato.
  La fórmula es:
  // initial: la suma inicial de dinero
  // interest: e.g. 0.05 significa 5% anual
  // years: cuántos años esperar
  let result = Math.round(initial * (1 + interest) ** years);
  */
  let form = document.forms.calculator;

  form.addEventListener("change", calcularDepositoFinal);

  function calcularDepositoFinal() {
    //calculo depósito final
    let initial = form.money.value;
    let years = form.months.value / 12;
    let interest = form.interest.value / 100;

    let result = Math.round(initial * (1 + interest) ** years);

    //visualización
    let final = document.getElementById("height-after");
    let height = result / 100 + 100; //ajuste del resultado al gŕafico
    final.style.height = height + "px";
  }
});
