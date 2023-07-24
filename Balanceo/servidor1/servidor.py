from flask import Flask, redirect

servidor1 = Flask(__name__)

@servidor1.route('/')
def hola():
	return redirect("http://www.google.com")
	
if __name__ == '__main__':
	servidor1.run(host = '0.0.0.0')