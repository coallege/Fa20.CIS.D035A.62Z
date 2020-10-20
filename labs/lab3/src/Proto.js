const fs = require("fs");
const rl = require("readline-sync");

function tryStatFile(file) {
	const absfile = fs.realpathSync(file);
	console.log(`stat: ${absfile}`)
	const stats = fs.statSync(absfile);

	if (stats.isFile) {
		console.log(`okay: ${absfile}`);
		return file;
	}

	console.log(`nope: ${absfile}`);
	return null;
}

let file = null;

const ZPATH = "Z:/JavaPrograms2/assignment336b/src/Salesdat.txt";

if (process.platform === "win32") {
	file = tryStatFile(ZPATH);
}

console.log(`Currently in ${__dirname}. Searching down the tree`);



fs.statSync("sales")
