const tolerance = 0.0001;

function apprxSqrt(n, old = n / 2) {
   const next = (old + n / old) / 2;
   if (Math.abs(next - old) > tolerance) {
      return apprxSqrt(n, next);
   } else {
      return next;
   }
}

/** Babyl method using trampoline */
function t_apprxSqrt(n) {
   let old;
   let next = n / 2; // could be any positive number but this is an okay start
   do {
      old = next;
      next = (old + n / old) / 2;
   } while (Math.abs(next - old) > tolerance);

   return next;
}
