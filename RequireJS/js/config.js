//This is configuration for js files

requirejs.config({
    baseURL: 'lib',
    paths: {
        angular: 'angular',
        jquery: [
            'https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min',
            'jquery'
        ]
    }
});