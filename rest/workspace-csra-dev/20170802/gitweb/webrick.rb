#!/usr/bin/env ruby
require 'webrick'
require 'logger'
options = {
  :Port => 1234,
  :DocumentRoot => "/usr/share/gitweb",
  :Logger => Logger.new('/opt/was/git/NYSOHRulesRepository/gitweb/error.log'),
  :AccessLog => [
    [ Logger.new('/opt/was/git/NYSOHRulesRepository/gitweb/access.log'),
      WEBrick::AccessLog::COMBINED_LOG_FORMAT ]
  ],
  :DirectoryIndex => ["gitweb.cgi"],
  :CGIInterpreter => "/opt/was/git/NYSOHRulesRepository/gitweb/webrick/wrapper.sh",
  :StartCallback => lambda do
    File.open("/opt/was/git/NYSOHRulesRepository/pid", "w") { |f| f.puts Process.pid }
  end,
  :ServerType => WEBrick::Daemon,
}
options[:BindAddress] = '127.0.0.1' if "" == "true"
server = WEBrick::HTTPServer.new(options)
['INT', 'TERM'].each do |signal|
  trap(signal) {server.shutdown}
end
server.start
