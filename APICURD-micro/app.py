from flask import Flask
from flask_cors import CORS

app = Flask(__name__)
CORS(app, resources={r"/api/*": {"origins": "*"}})

@app.route('/api/notif/delete', methods=['GET'])
def delete_notification():
    return 'Deleted successfully'

@app.route('/api/notif/create', methods=['GET'])
def create_notification():
    return 'Created successfully'

@app.route('/api/notif/login', methods=['GET'])
def login_notification():
    return 'Logged in successfully'

@app.route('/api/notif/logout', methods=['GET'])
def logout_notification():
    return 'Logged out successfully'

@app.route('/api/notif/incorrect', methods=['GET'])
def incorrect_notification():
    return 'Please fill all the fields correctly'

@app.route('/api/notif/invalid', methods=['GET'])
def invalid_notification():
    return 'Invalid credentials'

@app.route('/api/notif/unauth', methods=['GET'])
def unauth_notification():
    return 'Unauthorized action'

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5050)
